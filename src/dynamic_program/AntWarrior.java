package dynamic_program;

public class AntWarrior {

    public static void main(String[] args) {
        int[] param = {1,3,1,5};

        int[] a = new int[param.length];

        a[0] = param[0];
        a[1] = Math.max(a[0], param[1]);
        a[2] = Math.max(a[0] + param[2], a[1]);

        if (param.length == 3) {
            System.out.println(a[2]);
            return;
        }

        for (int i = 3; i < param.length; i++) {
            a[i] = Math.max(a[i - 2] + param[i], a[i - 1]);
        }

        System.out.println(a[param.length - 1]);
    }

}
