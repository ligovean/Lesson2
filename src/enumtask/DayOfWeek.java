package enumtask;

public enum DayOfWeek {
    MONDAY(40,"Понедельник"),TUESDAY(32,"Вторник"),WEDNESDAY(24,"Среда"),THURSDAY(16,"Четверг"),FRIDAY(8,"Пятница"),SATURDAY(0,"Суббота"),	SUNDAY(0,"Воскресение");

    private int hoursQty;
    private String name;
    DayOfWeek(int hoursQty, String name) {
        this.hoursQty = hoursQty;
        this.name = name;
    }

    public int getHoursQty() {
        return hoursQty;
    }
    public String getName() {
        return name;
    }
}
