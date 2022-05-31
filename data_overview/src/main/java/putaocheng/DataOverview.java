package putaocheng;

import java.util.*;

public class DataOverview {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter(";");  //将；设置为分隔符
        InputParam inputParam = initInput(scan.next());
        StringBuilder sb = new StringBuilder();
        List<InputParam.Item> itemList = inputParam.getItem();
        if ("Name".equals(inputParam.getSortField())) {
            itemList.sort(Comparator.comparing(InputParam.Item::getName));
        } else {
            itemList.sort(Comparator.comparing(InputParam.Item::getPillarNums));
        }
        if ("DESC".equals(inputParam.getSortType())) {
            Collections.reverse(itemList);
        }
        sb.append(getRow(RowTypeEnum.FIRST, inputParam.getMaxNameLength(), null, null));
        for (int i = 0; i < itemList.size(); i++) {
            sb.append(getRow(RowTypeEnum.ITEM, inputParam.getMaxNameLength(), itemList.get(i), inputParam.getMaxPillarNum()));
            if (i < itemList.size() - 1) {
                sb.append(getRow(RowTypeEnum.MEDIUM, inputParam.getMaxNameLength(), null, null));
            }
        }
        sb.append(getRow(RowTypeEnum.LAST, inputParam.getMaxNameLength(), null, null));
        System.out.println(sb);
    }

    private static InputParam initInput(String input) {
        InputParam inputParam = new InputParam();
        String[] strs = input.split("\n");
        String numStr = strs[0];
        //参数校验
        Integer num =Integer.parseInt(numStr);
        if(num<1 || num>20) {
            throw new IllegalArgumentException("行数不在范围内，1<=num<=20");
        }
        inputParam.setNum(num);
        String[] sorts = strs[1].split(" ");
        if (!"Value".equals(sorts[0]) && !"Name".equals(sorts[0])) {
            throw new IllegalArgumentException("请输入正确的排序方式，Name or Value");
        } else {
            inputParam.setSortField(sorts[0]);
        }
        if (!"ASC".equals(sorts[1]) && !"DESC".equals(sorts[1])) {
            throw new IllegalArgumentException("请输入正确的排序类型，DESC or ASC");
        } else {
            inputParam.setSortType(sorts[1]);
        }
        List<InputParam.Item> itemList = new ArrayList<>();
        int nameMaxLength = 0;
        int maxPillarNum = 0;
        for (int i = 2; i < strs.length; i++) {
            InputParam.Item item = new InputParam.Item();
            String[] itemStrs = strs[i].split(" ");
            item.setName(itemStrs[0]);
            item.setPillarNums(Integer.parseInt(itemStrs[1]));
            if (itemStrs[0].length() > nameMaxLength) {
                nameMaxLength = itemStrs[0].length();
            }
            if (item.getPillarNums() > maxPillarNum) {
                maxPillarNum = item.getPillarNums();
            }
            itemList.add(item);
        }
        inputParam.setMaxNameLength(nameMaxLength);
        inputParam.setMaxPillarNum(maxPillarNum);
        inputParam.setItem(itemList);
        return inputParam;
    }

    private static String getRow(RowTypeEnum type, Integer maxNameLength, InputParam.Item item, Integer maxPillarNum) {
        StringBuilder sb = new StringBuilder();
        sb.append(type.start);
        if (type.equals(RowTypeEnum.ITEM)) {
            for (int i = 0; i < maxNameLength - item.getName().length(); i++) {
                sb.append(Constant.EMPTY);
            }
            sb.append(item.getName());
            sb.append(type.split);
            int pillarNum = item.getPillarNums() * Constant.INT_20 / maxPillarNum;
            for (int i = 0; i < pillarNum; i++) {
                sb.append(Constant.PILLAR);
            }
            for (int i = 0; i < Constant.INT_20 - pillarNum; i++) {
                sb.append(Constant.EMPTY);
            }
        } else {
            for (int i = 0; i < maxNameLength; i++) {
                sb.append(Constant.TRANSVERSE);
            }
            sb.append(type.split);
            for (int i = 0; i < Constant.INT_20; i++) {
                sb.append(Constant.TRANSVERSE);
            }
        }
        sb.append(type.end).append("\n");
        return sb.toString();
    }

}
