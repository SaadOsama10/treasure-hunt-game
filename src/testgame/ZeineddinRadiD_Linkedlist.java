/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testgame;

import java.util.Random;

/**
 *
 * @author abood
 */
public class ZeineddinRadiD_Linkedlist<E> {

    ZeineddinRadiNode head;
    ZeineddinRadiNode tail;
    ZeineddinRadiNode ptemp;
    int size;

    void add(E data) {
        ZeineddinRadiNode n = new ZeineddinRadiNode(data);
        if (head == null) {
            head = n;

        } else {
            ZeineddinRadiNode temp = head;
            while (temp.next != null) {
                temp = temp.next;

            }
            temp.next = n;
        }
        size++;
    }

    void add(E data, int type, int value) {
        ZeineddinRadiNode n = new ZeineddinRadiNode(data, type, value);
        if (head == null) {
            head = n;
            tail = n;

        } else {
            ZeineddinRadiNode temp = head;
            while (temp.next != null) {
                temp = temp.next;

            }
            temp.next = n;
            n.prv = temp;
            tail = n;
        }
        size++;
        ptemp = head;
    }
//
//    E get(int item) {
//        if (item == 1) {
//            return (E) head.data;
//        }
//        ZeineddinRadiNode temp = head;
//        int index = 0;
//        while (temp.next != null) {
//            if (index == item) {
//                return (E) temp.data;
//            }
//            temp = temp.next;
//        }
//        return (E) head.data;
//    }

    public void movef() {
        if (ptemp != null && ptemp.next != null) {
            ptemp = ptemp.next;
        } else {
            System.out.println("Cannot move forward");
        }
    }

    public void movefor(int x) {
        if (ptemp.next == null) {
            return;
        }
        for (int i = 1; i <= x; i++) {
            ptemp = ptemp.next;

        }
    }

    public void moveforb(int x) {
        if (ptemp.prv == null) {
            return;
        }
        for (int i = 0; i > x; i--) {
            ptemp = ptemp.prv;

        }
    }

//    void moveb() {
//
//        ptemp = ptemp.prv;
//    }

    public int getRandomSpotType() {
        int rend = new java.util.Random().nextInt(5); 
        return rend;
    }

    public int getRandomSpotValue() {
        int rend = new java.util.Random().nextInt(4) + 1;
        return rend;
    }

}
