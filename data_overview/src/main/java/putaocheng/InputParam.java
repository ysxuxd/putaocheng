package putaocheng;

import java.util.List;

public class InputParam {
    private Integer num;
    private String sortType;
    private String sortField;
    private List<Item> item;
    private Integer maxNameLength;
    private Integer maxPillarNum;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public Integer getMaxPillarNum() {
        return maxPillarNum;
    }

    public void setMaxPillarNum(Integer maxPillarNum) {
        this.maxPillarNum = maxPillarNum;
    }

    public Integer getMaxNameLength() {
        return maxNameLength;
    }

    public void setMaxNameLength(Integer maxNameLength) {
        this.maxNameLength = maxNameLength;
    }

    public static class Item {
        private String name;         //条目名称
        private Integer pillarNums;  //柱子数量

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getPillarNums() {
            return pillarNums;
        }

        public void setPillarNums(Integer pillarNums) {
            this.pillarNums = pillarNums;
        }
    }
}