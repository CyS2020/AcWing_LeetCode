package base;

/**
 * @author: CyS2020
 * @date: 2021/9/25
 * 描述：Trie树节点
 */
public class TrieNode {

    public char ch;

    public int count;

    public TrieNode[] next = new TrieNode[26];

    public TrieNode(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}
