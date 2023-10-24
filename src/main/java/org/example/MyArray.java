package org.example;

/**
 * 자료구조 - 배열
 *
 * 배열의 특징
 * 1. 동일한 데이터 타입을 순서에 따라 관리하는 자료 구조
 * 2. 정해진 크기가 있음
 * 3. 요소의 추가와 제거시 다른 요소들의 이동이 필요함
 * 4. 배열의 i 번째 요소를 찾는 인덱스 연산이 빠름
 * 5. jdk 클래스 : ArrayList, Vector
 */
public class MyArray {
    int[] intArr; // int array
    int count;  // 개수

    public int ARRAY_SIZE;
    public static final int ERROR_NUM = -99999999;

    public MyArray() {
        count = 0;
        ARRAY_SIZE = 10;
        intArr = new int[ARRAY_SIZE];
    }

    public MyArray(int size) {
        count = 0;
        ARRAY_SIZE = size;
        intArr = new int[size];
    }

    public void addElement(int num) {
        if(count >= ARRAY_SIZE) {
            System.out.println("not enough memory");
            return;
        }
        intArr[count++] = num;
    }

    public void insertElement(int position, int num) {
        int i;

        if(position < 0 || position > count) {
            System.out.println("insert Error");
            return;
        }

        if(count >= ARRAY_SIZE){
            System.out.println("not enough memory");
            return;
        }

        for (i = position-1; i >= position; i--) {
            intArr[i+1] = intArr[i];
        }

        intArr[position] = num;
        count++;
    }

    public int removeElement(int position) {
        int ret = ERROR_NUM;

        if (isEmpty()) {
            System.out.println("There is no element");
            return ret;
        }
        if(position < 0 || position >= count ){  //index error
            System.out.println("remove Error");
            return ret;
        }

        ret = intArr[position];

        for(int i = position; i<count -1; i++ )
        {
            intArr[i] = intArr[i+1];
        }
        count--;
        return ret;

    }

    private boolean isEmpty() {
        if(count == 0 ) {
            return false;
        } else {
            return true;
        }
    }

    public int getSize() {
        return count;
    }
}
