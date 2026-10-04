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
public class ZeineddinRadiLinkedlist<E> {

    ZeineddinRadiNode head;
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
        ptemp = head;
    }

    void add(E data, int type) {
        ZeineddinRadiNode n = new ZeineddinRadiNode(data, type);
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
        ptemp = head;
    }

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
    void move() {
        if (ptemp.next == null) {
            return;
        }
        ptemp = ptemp.next;
    }

    public int getRandomSpotType() {
        int rend = new Random().nextInt(3); // 0, 1, or 2
        return rend;
    }

}
