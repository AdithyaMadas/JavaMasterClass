public class PaintJob {
    public static int getBucketCount(double h, double w, double perBucket, int buckets) {
        if (h <= 0 || w <= 0 || perBucket <= 0 || buckets < 0) {
            return -1;
        }
        int BucketsReq = (int) Math.ceil((h * w) / perBucket);
        return BucketsReq - buckets;
    }
    public static int getBucketCount(double h, double w, double perBucket) {
        return getBucketCount(h, w, perBucket, 0);
    }
    public static int getBucketCount(double area, double perBucket) {
        return getBucketCount(area, 1, perBucket, 0);
    }

    public static void main(String[] args) {
        System.out.println(getBucketCount(2.75, 3.25, 2.5));
    }
}
