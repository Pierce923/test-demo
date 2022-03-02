package cc.fivelong.t02_jmm;

public class T_02_Synchronized {

    synchronized void m(){

    }

    void n(){
        synchronized (this){

        }
    }

}
