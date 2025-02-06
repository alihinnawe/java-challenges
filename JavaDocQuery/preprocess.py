from sentence_transformers import SentenceTransformer
import json
import numpy as np
import os
import sys

# Load the Sentence-BERT model
model = SentenceTransformer('all-MiniLM-L6-v2')

def load_data(filename):
    """Loads class map data from a JSON file."""
    try:
        with open(filename, 'r', encoding='utf-8') as f:
            return json.load(f)
    except FileNotFoundError:
        print(f"Error: File {filename} not found.")
        sys.exit(1)
    except json.JSONDecodeError as e:
        print(f"Error: Invalid JSON format in {filename}. Error: {e}")
        sys.exit(1)

def generate_embeddings(class_map, embedding_cache_file):
    """Generates and saves embeddings for class descriptions."""
    descriptions = list(class_map.values())

    if not descriptions:
        print("Error: No descriptions found in class_map.json")
        sys.exit(1)

    embeddings = model.encode(descriptions, convert_to_numpy=True)

    # Save embeddings
    np.save(embedding_cache_file, embeddings)
    print(f"Saved {len(descriptions)} embeddings to {embedding_cache_file}")

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: python preprocess.py <class_map_file>")
        sys.exit(1)

    class_map_file = sys.argv[1]
    embedding_cache_file = "class_embeddings.npy"

    # Load data
    class_map = load_data(class_map_file)

    if not class_map:
        print("Error: class_map.json is empty.")
        sys.exit(1)

    # Generate and save embeddings
    generate_embeddings(class_map, embedding_cache_file)
