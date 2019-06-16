package com.patternDesign.facade;

public class ComputerFacade {
    Cpu cpu = new Cpu();
    Memory memory = new Memory();
    Disk disk = new Disk();

    public void start() {
        cpu.start();
        memory.start();
        disk.start();
    }

    public void shutDown() {
        cpu.shutDown();
        memory.shutDown();
        disk.shutDown();
    }
}
