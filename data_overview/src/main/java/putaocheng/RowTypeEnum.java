package putaocheng;

public enum RowTypeEnum {
    FIRST(Constant.LEFT_UP,Constant.CROSS_DOWN,Constant.RIGHT_UP),
    LAST(Constant.LEFT_DOWN,Constant.CROSS_UP,Constant.RIGHT_DOWN),
    MEDIUM(Constant.CROSS_RIGHT,Constant.CROSS,Constant.CROSS_LEFT),
    ITEM(Constant.VERTICAL,Constant.VERTICAL,Constant.VERTICAL);

    final String start;
    final String split;
    final String end;

    RowTypeEnum(String start, String split, String end) {
        this.start = start;
        this.split = split;
        this.end = end;
    }
}
