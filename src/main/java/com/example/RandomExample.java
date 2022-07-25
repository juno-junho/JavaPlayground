public class RandomExample {
    // 배열 arr를 from과 to 범위의 값들로 채워 반환
    static int[] fillRand(int[] arr, int from, int to){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRand(from, to);
        }
        return arr;
    }
    // 배열 arr값을 data에 있는 값들로 채워서 반환.
    static int[] fillRand(int[] arr, int[] data){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = data[getRand(0, data.length-1)];
        }
        return arr;
    }

    // from과 to 범위의 정수 값을 반환함. from 과 to 모두 범위에 포함.
    static int getRand(int from, int to){
        return (int)(Math.random() * (Math.abs(to-from) + 1)) + Math.min(from, to);
    }
}