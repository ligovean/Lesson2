package enumtask;

public class DayOfWeekMain {

    public static void main(final String[] args) {

        System.out.println(getWorkingHours(DayOfWeek.MONDAY)); //Пример из задания
        System.out.println();

        //Для вывода по всем дням недели
        System.out.println("=============/Вывод всех дней недели/=============");

        System.out.printf("В этой неделе %s рабочих часов.\n", DayOfWeek.MONDAY.getWeekHours());
        for (DayOfWeek d: DayOfWeek.values()){
            System.out.printf("Сейчас %s. %s\n",d.getName(),getWorkingHours(d));
        }
    }

    public static String getWorkingHours(DayOfWeek d){
        if (d.getHoursQty()==0)
            return "Выходной день!";
        return "Осталось " + d.getRemainHours() + " ч. до конца рабочей недели!";
    }
}