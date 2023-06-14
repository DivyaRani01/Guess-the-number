class sum {
    public static void main(String[] args) {
        calc c = new calc();
        c.addition(1, 2, 3, 4, 5);
    }
}

class calc {
    public void addition(int... bs) {
        int sum = 0;
        for (int i : bs) {
            sum += i;
        }
        System.out.println("sum is: " + sum);
    }
}
