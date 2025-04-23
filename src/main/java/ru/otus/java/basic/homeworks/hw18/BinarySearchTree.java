package ru.otus.java.basic.homeworks.hw18;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements SearchTree<T> {
    private static class TreeNode<T> {
        T value;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode<T> root;

    public BinarySearchTree(List<T> sortedList) {
        if (sortedList == null || sortedList.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть null или пустым");
        }
        this.root = buildTree(sortedList, 0, sortedList.size() - 1);
    }

    private TreeNode<T> buildTree(List<T> sortedList, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode<T> node = new TreeNode<>(sortedList.get(mid));
        node.left = buildTree(sortedList, start, mid - 1);
        node.right = buildTree(sortedList, mid + 1, end);

        return node;
    }

    @Override
    public T find(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Элемент не может быть null");
        }
        return findRecursive(root, element);
    }

    private T findRecursive(TreeNode<T> node, T element) {
        if (node == null) {
            return null;
        }

        int cmp = element.compareTo(node.value);
        if (cmp == 0) {
            return node.value; // Элемент найден
        } else if (cmp < 0) {
            return findRecursive(node.left, element); // Ищем в левом поддереве
        } else {
            return findRecursive(node.right, element); // Ищем в правом поддереве
        }
    }

    @Override
    public List<T> getSortedList() {
        List<T> sortedList = new ArrayList<>();
        inOrderTraversal(root, sortedList);
        return sortedList;
    }

    private void inOrderTraversal(TreeNode<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, result);
        result.add(node.value);
        inOrderTraversal(node.right, result);
    }
}