import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public interface soundHandler {

    void handleRequest( String request );
    void setSuccessor(soundHandler next);

}


