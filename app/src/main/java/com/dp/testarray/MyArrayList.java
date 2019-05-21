package com.dp.testarray;


public class MyArrayList<E> {
    private static final int DEFULT_CAPACITY = 10;
    private Object[] mas;
    private int size;


    public MyArrayList() {
        mas = new Object[DEFULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int capacity) {
        mas = new Object[capacity];
        size = 0;
    }

    private void controlSize() {
        if (size == mas.length) {
            int newLength = size * 3 / 2 + 1;
            Object[] nMas = new Object[newLength];
            System.arraycopy(mas, 0, nMas, 0, size);
            mas = nMas;
        }
    }

    public boolean add(E e) {
        controlSize();
        mas[size++] = e;
        return true;
    }

    public void add(int index, E e) {
        controlSize();
        System.arraycopy(mas, index, mas, index + 1, size - index);
        size++;
        mas[index] = e;
    }

    public E remove(int index) {
        if (index > size && index >= 0) {
            E e = (E) mas[index];
            System.arraycopy(mas, index + 1, mas, index, size - 1 - index);
            size--;
            return e;
        }  else return null;
    }

    public E get (int index) {
        return (E) mas[index];
    }

    public E set(int index, E e) {
        E elemByIndex = get(index);
        mas[index] = e;
        return elemByIndex;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
         StringBuilder sb = new StringBuilder();
          sb.append('[');
        for (int i = 0; i < size ; i++) {
          if(mas[i] !=null) {
              sb.append(mas[i].toString());
          }
          else sb.append("null");
          if (i !=size -1 ) sb.append(", ");
        }
        sb.append(']');
        return sb.toString();
    }
}
