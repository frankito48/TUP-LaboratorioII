class DiscountRate {
    static double serviceDiscountPremium = 0.2;
    static double serviceDiscountGold = 0.15;
    static double serviceDiscountSilver = 0.1;
    static double productDiscountPremium = 0.1;
    static double productDiscountGold = 0.1;
    static double productDiscountSilver = 0.1;

    public static double getServiceDiscountRate(String type) {
        if (type.equals("Premium")) {
            return serviceDiscountPremium;
        } else if (type.equals("Gold")) {
            return serviceDiscountGold;
        } else if (type.equals("Silver")) {
            return serviceDiscountSilver;
        }
        return 0;
    }

    public static double getProductDiscountRate(String type) {
        if (type.equals("Premium") || type.equals("Gold") || type.equals("Silver")) {
            return 0.1;
        }
        return 0;
    }
}