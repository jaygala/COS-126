public class BeadFinder {

    Picture pic;
    double tau;
    Blob[] blobs;
    double[][] lum_values;
    boolean[][] visited;
    Stack<Blob> all_blobs;

    //  finds all blobs in the specified picture using luminance threshold tau
    public BeadFinder(Picture picture, double tau) {
        this.pic = picture;
        this.tau = tau;
        lum_values = new double[pic.width()][pic.height()];
        visited = new boolean[pic.width()][pic.height()];
        for (int i = 0; i < pic.width(); i++) {
            for (int j = 0; j < pic.height(); j++) {
                lum_values[i][j] = Luminance.lum(pic.get(i, j));
                visited[i][j] = false;
            }
        }

        all_blobs = new Stack<>();
        // Stack<int[]> one_blob = new Stack<>();

        for (int i = 0; i < pic.width(); i++) {
            for (int j = 0; j < pic.height(); j++) {
                if (visited[i][j] || lum_values[i][j] < tau) {
                    continue;
                }
                Blob my_blob = new Blob();
                visited[i][j] = true;
                my_blob.add(i, j);
                Blob to_push = DFS(my_blob, i, j);
                // System.out.println("Size of the new blob to push is - " + to_push);
                all_blobs.push(to_push);
            }
        }


    }

    private Blob DFS(Blob my_blob, int i, int j) {
        try {
            if (!visited[i + 1][j] && lum_values[i + 1][j] >= tau) {
                visited[i + 1][j] = true;
                my_blob.add(i + 1, j);
                DFS(my_blob, i + 1, j);
            }
        }
        catch (Exception ignored) {
        }

        try {
            if (!visited[i - 1][j] && lum_values[i - 1][j] >= tau) {
                visited[i - 1][j] = true;
                my_blob.add(i - 1, j);
                DFS(my_blob, i - 1, j);
            }
        }
        catch (Exception ignored) {
        }

        try {
            if (!visited[i][j + 1] && lum_values[i][j + 1] >= tau) {
                visited[i][j + 1] = true;
                my_blob.add(i, j + 1);
                DFS(my_blob, i, j + 1);
            }
        }
        catch (Exception ignored) {
        }

        try {
            if (!visited[i][j - 1] && lum_values[i][j - 1] >= tau) {
                visited[i][j - 1] = true;
                my_blob.add(i, j - 1);
                DFS(my_blob, i, j - 1);
            }
        }
        catch (Exception ignored) {
        }


        return my_blob;
    }

    //  returns all beads (blobs with >= min pixels)
    public Blob[] getBeads(int min) {
        Stack<Blob> few_blobs = new Stack<>();
        while (!all_blobs.isEmpty()) {
            Blob b = all_blobs.pop();
            if (b.mass() >= min) {
                few_blobs.push(b);
            }
        }
        int size = few_blobs.size();
        int i = 0;
        blobs = new Blob[size];
        while (!few_blobs.isEmpty()) {
            Blob b2 = few_blobs.pop();
            blobs[i] = b2;
            i++;
        }

        return blobs;
    }

    //  test client, as described below
    public static void main(String[] args) {
        int min = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        Picture picture = new Picture(args[2]);
        BeadFinder beadFinder = new BeadFinder(picture, tau);
        Blob[] result = beadFinder.getBeads(min);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
