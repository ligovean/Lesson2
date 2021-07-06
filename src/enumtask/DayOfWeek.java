package enumtask;

public enum DayOfWeek {
    //MONDAY(40,"Понедельник"),TUESDAY(32,"Вторник"),WEDNESDAY(24,"Среда"),THURSDAY(16,"Четверг"),FRIDAY(8,"Пятница"),SATURDAY(0,"Суббота"),SUNDAY(0,"Воскресение");

    //Для каждого дня определено свое количество рабочих часов.
    MONDAY(8,"Понедельник"),TUESDAY(8,"Вторник"),WEDNESDAY(0,"Среда"),THURSDAY(5,"Четверг"),FRIDAY(8,"Пятница"),SATURDAY(0,"Суббота"),	SUNDAY(0,"Воскресение");

    private int hoursQty;
    private String name;

    DayOfWeek(int hoursQty, String name) {
        this.hoursQty = hoursQty;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHoursQty() {
        return hoursQty;
    }

    public int getRemainHours() { //Метод получения количества оставшихся часов до конца рабочей недели
        int workedHours = 0;

        for (DayOfWeek d:DayOfWeek.values()) {
            if (d.ordinal() == this.ordinal())
                break;
            workedHours += d.hoursQty;
        }
        return getWeekHours() - workedHours;
    }

    public int getWeekHours(){ //Метод получения количества рабочих часов в неделе, которой принадлежит данный день
        int allWeekHours = 0;
        for (DayOfWeek d:DayOfWeek.values()) {
            allWeekHours += d.hoursQty;
        }
        return allWeekHours;
    }
}
