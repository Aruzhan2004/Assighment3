public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K, V>[] chainArray; // or Object[]
    private int M = 11; // default number of chains
    private int size;
    public MyHashTable(){
        chainArray = new HashNode[M];
    }
    public MyHashTable (int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }
    private int hash(K key) {
        return Math.abs(key.hashCode() % M);
    }
    public void put(K key, V value) {
        int indx = hash(key);
        HashNode<K, V> node = chainArray[indx];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[indx];
        chainArray[indx] = newNode;
        size++;
    }
    public V get(K key) {
        int indx = hash(key);
        HashNode<K, V> node = chainArray[indx];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    public V remove(K key) {
        int indx = hash(key);
        HashNode<K, V> node = chainArray[indx];
        HashNode<K, V> trgt = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (trgt == null) {
                    chainArray[indx] = node.next;
                } else {
                    trgt.next = node.next;
                }
                size--;
                return node.value;
            }
            trgt = node;
            node = node.next;
        }
        return null;

    }
    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;

    }
    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }
}

