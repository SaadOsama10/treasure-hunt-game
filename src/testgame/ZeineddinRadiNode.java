/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testgame;

/**
 *
 * @author abood
 */
public class ZeineddinRadiNode<E> {

    E data;
    int type;
    int value;
    ZeineddinRadiNode next;
    ZeineddinRadiNode prv;

    public ZeineddinRadiNode(E data) {
        this.data = data;
        this.next = null;
        this.prv = null;

    }

    public ZeineddinRadiNode(E data, int type) {
        this.data = data;
        this.type = type;
        this.next = null;
        this.prv = null;

    }

    public ZeineddinRadiNode(E data, int type, int v) {
        this.data = data;
        this.type = type;
        this.next = null;
        this.prv = null;
        this.value = v;

    }

}
