package com.models;

public class Edge  {
    private final String id;
    private final Vertex source;
    private final Vertex destination;
    private final int weight;
    private final String route;

    public Edge(String id, Vertex source, Vertex destination, int weight,String route) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.route = route;
    }

    public String getId() {
        return id;
    }
    public Vertex getDestination() {
        return destination;
    }

    public Vertex getSource() {
        return source;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + " " + destination;
    }

    public String getDirections() {
        return route;
    }

    
}