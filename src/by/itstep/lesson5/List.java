package by.itstep.lesson5;

public final class List {

    private Object[] buffer;
    private int current = -1;

    public  List(int initialLength){
        if(initialLength < 1)
            initialLength = 1;
        buffer = new Object[initialLength];
    }

    public void Add(Object item){
        current++;
        if(current > buffer.length - 1)
           Grow();
        buffer[current] = item;
    }

    public Object getByIndex(int index){
        if(index < buffer.length && index >= 0)
            return  buffer[index];
        return  null;
    }

    public int count(){
        return  buffer.length;
    }

    private void Grow(){
        Object[] newBuffer = new Object[buffer.length * 2];
        for (int i = 0; i< buffer.length; i++){
            newBuffer[i] = buffer[i];
        }
        buffer = newBuffer;
    }
}
