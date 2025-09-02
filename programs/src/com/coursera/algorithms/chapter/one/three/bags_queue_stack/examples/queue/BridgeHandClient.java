package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.queue;

public class BridgeHandClient {
    private static class Card {
        String rank;
        String suit;

        Card(String rank, String suit) {
            this.rank = rank;
            this.suit = suit;
        }

        public String toString() {
            return rank + " " + suit;
        }
    }
    public static void main(String[] args) {
        String[] suits = {"CLUB", "DIAMOND", "HEART", "SPADE"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        RandomQueue<Card> queue = new RandomQueue<Card>();

        for (String suit : suits) {
            for (String rank : ranks) {
                queue.enqueue(new Card(rank,suit));
            }
        }

        String[] players = {"north", "south", "east", "west"};

        for(String player : players) {
            System.out.println("Player " + player + "'s cards are:");
            for(int i = 0; i < 13; i++) {
                System.out.println(queue.dequeue());
            }
            System.out.println("-".repeat(10));
        }
    }
}
