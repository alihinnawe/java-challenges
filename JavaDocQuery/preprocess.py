from sentence_transformers import SentenceTransformer, util
import json
import numpy as np
import sys

# Pre-load the BERT model globally
model = SentenceTransformer('all-MiniLM-L6-v2')

def load_data(filename):
    try:
        with open(filename, 'r', encoding='utf-8') as f:
            return json.load(f)
    except FileNotFoundError:
        print(f"Error: File {filename} not found.")
        sys.exit(1)
    except json.JSONDecodeError as e:
        print(f"Error: Invalid JSON format in file {filename}. Error: {e}")
        sys.exit(1)

def load_embeddings(embedding_cache_file):
    if not os.path.exists(embedding_cache_file):
        print(f"Error: Embedding cache file {embedding_cache_file} not found. Run preprocess.py first.")
        sys.exit(1)
    return np.load(embedding_cache_file)

def find_relevant_entries(query, class_map, embeddings):
    query_embedding = model.encode(query, convert_to_tensor=True)
    similarities = util.cos_sim(query_embedding, embeddings)[0]
    sorted_results = sorted(zip(similarities, class_map.items()), key=lambda x: x[0], reverse=True)

    return [(key, desc, score.item()) for score, (key, desc) in sorted_results[:5]]

if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Usage: python query.py <query> <class_map_file>")
        sys.exit(1)

    query = sys.argv[1]
    class_map_file = sys.argv[2]

    print(f"Query: {query}")
    print(f"Class Map File: {class_map_file}")

    # Load data from JSON file
    class_map = load_data(class_map_file)

    if not class_map:
        print("Error: The class_map.json file is empty or does not contain any entries.")
        sys.exit(1)

    # Define the embedding cache file
    embedding_cache_file = "class_embeddings.npy"

    # Load cached embeddings
    embeddings = load_embeddings(embedding_cache_file)

    # Find relevant entries
    results = find_relevant_entries(query, class_map, embeddings)

    if not results:
        print("No relevant results found.")
    else:
        for key, desc, score in results:
            print(f"{key}: {desc} (Score: {score:.4f})")