package com.ramilaiv.tomiatesttasktesteditor.service;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;

import java.util.ArrayList;



import javax.swing.event.ChangeEvent;



/**

 * Manages a Queue of Changables to perform undo and/or redo operations. Clients can add implementations of the Changeable

 * class to this class, and it will manage undo/redo as a Queue.

 *

 * @author Greg Cope

 *

 */

@Component
public class ChangeManager {


    //the current index node

    private Node currentIndex = null;

    //the parent node far left node.

    private Node parentNode = new Node();


    /**
     * Creates a new ChangeManager object which is initially empty.
     */

    public ChangeManager() {

        currentIndex = parentNode;

    }


    /**
     * Creates a new ChangeManager which is a duplicate of the parameter in both contents and current index.
     *
     * @param manager
     */

    public ChangeManager(ChangeManager manager) {

        this();

        currentIndex = manager.currentIndex;

    }


    /**
     * Clears all Changables contained in this manager.
     */

    public void clear() {

        currentIndex = parentNode;

    }


    /**
     * Adds a Changeable to manage.
     *
     * @param changeable
     */

    public String addChangeable(Changeable changeable) {

        Node node = new Node(changeable);

        currentIndex.right = node;

        node.left = currentIndex;

        currentIndex = node;
        return currentIndex.changeable.getLabel().getText();

    }

    /**
     * Adds a Changeable to manage.
     *
     * @param changeable
     */

    public Changeable getChangable() {

        if(currentIndex.changeable == null){
            return new MyLabel("");
        }
        return currentIndex.changeable;

    }


    /**
     * Determines if an undo can be performed.
     *
     * @return
     */

    public boolean canUndo() {

        return currentIndex != parentNode;

    }


    /**
     * Determines if a redo can be performed.
     *
     * @return
     */

    public boolean canRedo() {

        return currentIndex.right != null;

    }


    /**
     * Undoes the Changeable at the current index.
     *
     * @throws IllegalStateException if canUndo returns false.
     */

    public Label undo() {

        //validate

        if (!canUndo()) {

            throw new IllegalStateException("Cannot undo. Index is out of range.");

        }

        //undo

        currentIndex.changeable.undo();

        //set index

          return moveLeft();

    }


    /**
     * Moves the internal pointer of the backed linked list to the left.
     *
     * @throws IllegalStateException If the left index is null.
     */

    private  Label moveLeft() {

        if (currentIndex.left == null) {

            throw new IllegalStateException("Internal index set to null.");

        }

        currentIndex = currentIndex.left;

        return currentIndex.changeable.getLabel();
    }


    /**
     * Moves the internal pointer of the backed linked list to the right.
     *
     * @throws IllegalStateException If the right index is null.
     */

    private void moveRight() {

        if (currentIndex.right == null) {

            throw new IllegalStateException("Internal index set to null.");

        }

        currentIndex = currentIndex.right;

    }


    /**
     * Redoes the Changable at the current index.
     *
     * @throws IllegalStateException if canRedo returns false.
     */

    public void redo() {

        //validate

        if (!canRedo()) {

            throw new IllegalStateException("Cannot redo. Index is out of range.");

        }

        //reset index

        moveRight();

        //redo

        currentIndex.changeable.redo();

    }



    /**
     * Inner class to implement a doubly linked list for our queue of Changeables.
     *
     * @author Greg Cope
     */

    private class Node {

        private Node left = null;

        private Node right = null;


        private final Changeable changeable;


        public Node(Changeable c) {

            changeable = c;

        }


        public Node() {

            changeable = null;

        }

    }
}
