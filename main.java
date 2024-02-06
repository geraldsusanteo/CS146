class Main {
    public static void main(String[] args) {
        int[] numbers = {17,27,2003,12,1,500,1000,5};
        int target = 6;
        int[] answer = new int[2];

        for(int i = 0; i<numbers.length;i++ ) {
            int key = target - numbers[i];
            for(int j=0; j<numbers.length; j++) {
                if(numbers[j] == key && j!=i) {
                    answer[0]=j;
                    answer[1]=i;
                    break;
                    }
                }
            }
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        }
    }