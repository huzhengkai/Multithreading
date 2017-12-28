package com.huzhengkai.chapter_12.Sample;


import com.huzhengkai.chapter_12.Sample.activeobject.ActiveObject;
import com.huzhengkai.chapter_12.Sample.activeobject.ActiveObjectFactory;

public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakerClientThread("Alice", activeObject).start();
        new MakerClientThread("Bobby", activeObject).start();
        new DisplayClientThread("Chris", activeObject).start();
    }
}
