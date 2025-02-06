from sentence_transformers import SentenceTransformer, util
import json
import numpy as np
import os
import sys
import logging
import torch 

# Configure logging
logging.basicConfig(level=logging.INFO, format="%(levelname)s: %(message)s")

# Load the Sentence-BERT model
device = "cuda" if torch.cuda.is_available() else "cpu"
model = SentenceTransformer('all-MiniLM-L6-v2', device=device)

def load_data(filename):
    """Loads class map data from a JSON file."""
    if not os.path.exists(filename):
        logging.error(f"File {filename} not found.")
        sys.exit(1)
    
    try:
        with open(filename, 'r', encoding='utf-8') as f:
            return json.load(f)
    except json.JSONDecodeError as e:
        logging.error(f"Invalid JSON format in {filename}. Error: {e}")
        sys.exit(1)

def load_embeddings(embedding_cache_file):
    """Loads the cached embeddings from a NumPy file."""
    if not os.path.exists(embedding_cache_file):
        logging.error(f"Embedding cache file {embedding_cache_file} not found. Run preprocess.py first.")
        sys.exit(1)
    
    return np.load(embedding_cache_file)

def find_relevant_entries(query, class_map, embeddings, top_k=5):
    """Finds the most relevant class descriptions using cosine similarity."""
    query_embedding = model.encode(query, convert_to_tensor=True, device=device)

    # Compute cosine similarities
    similarities = util.cos_sim(query_embedding, embeddings)[0].cpu().numpy()

    # Get indices of top-k results efficiently
    top_indices = np.argpartition(-similarities, top_k)[:top_k]
    top_results = sorted([(similarities[i], key, desc) for i, (key, desc) in enumerate(class_map.items()) if i in top_indices], reverse=True)

    return [(key, desc, score) for score, key, desc in top_results]

if __name__ == "__main__":
    if len(sys.argv) < 3:
        print("Usage: python query.py '<query>' <class_map_file> [top_k]")
        sys.exit(1)

    query = " ".join(sys.argv[1:-1])  # Capture full query
    class_map_file = sys.argv[-1]
    top_k = int(sys.argv[-1]) if sys.argv[-1].isdigit() else 5  # Optional top_k argument

    logging.info(f"Query: {query}")
    logging.info(f"Class Map File: {class_map_file}")
    logging.info(f"Retrieving top {top_k} matches...")

    # Load class data
    class_map = load_data(class_map_file)

    if not class_map:
        logging.error("Error: class_map.json is empty.")
        sys.exit(1)

    # Load precomputed embeddings
    embedding_cache_file = "class_embeddings.npy"
    embeddings = load_embeddings(embedding_cache_file)

    # Find and print relevant results
    results = find_relevant_entries(query, class_map, embeddings, top_k=top_k)

    if not results:
        logging.warning("No relevant results found.")
    else:
        for key, desc, score in results:
            print(f"{key}: {desc} (Score: {score:.4f})")
