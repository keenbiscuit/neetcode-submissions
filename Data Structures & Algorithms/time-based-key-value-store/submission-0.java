class TimeMap {
    private String key;
    private String value;
    private int timestamp;

    Map<String, List<Pair<Integer, String>>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> list = timeMap.getOrDefault(key, new ArrayList<>());
        int left = 0, right = list.size() - 1;
        String result = "";

        while (left <= right) {
            // Calculate mid
            int mid = left + ((right - left) / 2);

            if(list.get(mid).getKey() <= timestamp)
            {
                result = list.get(mid).getValue();
                left = mid + 1;
            }
            else
            right = mid - 1;
        }
        return result;
    }
}
