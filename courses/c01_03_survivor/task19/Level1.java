import java.util.*;

public class Level1
{
    public static String [] ShopOLAP(int N, String [] items)
      {
        java.util.HashMap<String, Integer> salesByItem = new java.util.HashMap<String, Integer>();

        for (int i = 0; i < N; i++) {
            String saleRecord = items[i];

            int separatorIndex = saleRecord.indexOf(' ');
            String itemName = saleRecord.substring(0, separatorIndex);
            int soldCount = Integer.parseInt(saleRecord.substring(separatorIndex + 1));

            if (salesByItem.containsKey(itemName)) {
                salesByItem.put(itemName, salesByItem.get(itemName) + soldCount);
            } else {
                salesByItem.put(itemName, soldCount);
            }
        }

        String[] itemNames = new String[salesByItem.size()];
        int index = 0;

        for (String key : salesByItem.keySet()) {
            itemNames[index] = key;
            index++;
        }

        for (int i = 0; i < itemNames.length - 1; i++) {
            for (int j = i + 1; j < itemNames.length; j++) {
                String firstItemName = itemNames[i];
                String secondItemName = itemNames[j];

                int firstItemSoldCount = salesByItem.get(firstItemName);
                int secondItemSoldCount = salesByItem.get(secondItemName);

                boolean needSwap = false;

                if (secondItemSoldCount > firstItemSoldCount) {
                    needSwap = true;
                } else if (secondItemSoldCount == firstItemSoldCount) {
                    int minItemNameLength = firstItemName.length();

                    if (secondItemName.length() < minItemNameLength) {
                        minItemNameLength = secondItemName.length();
                    }

                    boolean comparisonDecided = false;

                    for (int k = 0; k < minItemNameLength; k++) {
                        if (!comparisonDecided) {
                            if (secondItemName.charAt(k) < firstItemName.charAt(k)) {
                                needSwap = true;
                                comparisonDecided = true;
                            } else if (secondItemName.charAt(k) > firstItemName.charAt(k)) {
                                comparisonDecided = true;
                            }
                        }
                    }

                    if (!comparisonDecided && secondItemName.length() < firstItemName.length()) {
                        needSwap = true;
                    }
                }

                if (needSwap) {
                    String temp = itemNames[i];
                    itemNames[i] = itemNames[j];
                    itemNames[j] = temp;
                }
            }
        }

        String[] result = new String[itemNames.length];

        for (int i = 0; i < itemNames.length; i++) {
            result[i] = itemNames[i] + " " + salesByItem.get(itemNames[i]);
        }

        return result;
      }
}

