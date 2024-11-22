public class AppointmentBook 
{
    
    public AppointmentBook (boolean[][] schedule)
    {
        this.schedule = schedule;
    }

    private boolean[][] schedule;
    /**
     * Returns true if minute in period is available for an appointment and returns
     * false otherwise
     * Preconditions: 1 <= period <= 8; 0 <= minute <= 59
     */


    private boolean isMinuteFree(int period, int minute) 
    {
        return schedule[period - 1][minute];
    }

    /**
     * Marks the block of minutes that starts at startMinute in period and
     * is duration minutes long as reserved for an appointment
     * Preconditions: 1 <= period <= 8; 0 <= startMinute <= 59;
     * 1 <= duration <= 60
     */
    private void reserveBlock(int period, int startMinute, int duration) 
    {
        for (int i = startMinute; i < (startMinute + duration); i++) 
        {
        schedule[period - 1][i] = false;
        }
        /* implementation not shown */ 
    }

    /**
     * Searches for the first block of duration free minutes during period, as
     * described in
     * part (a). Returns the first minute in the block if such a block is found or
     * returns -1 if no
     * such block is found.
     * Preconditions: 1 <= period <= 8; 1 <= duration <= 60
     */
    public int findFreeBlock(int period, int duration) 
    {
        /* to be implemented in part (a) */ 
        int block = 0;
        for (int i = 0; i < 60; i++)
        {
            if (isMinuteFree(period, i))
            {
                block++;
                if (block == duration)
                {
                    return i - duration + 1;
                }

            }
            else
            {
                block = 0;
            }

        }

        return -1;

    }

    /**
     * Searches periods from startPeriod to endPeriod, inclusive, for a block
     * of duration free minutes, as described in part (b). If such a block is found,
     * calls reserveBlock to reserve the block of minutes and returns true;
     * otherwise
     * returns false.
     * Preconditions: 1 <= startPeriod <= endPeriod <= 8; 1 <= duration <= 60
     */
    public boolean makeAppointment(int startPeriod, int endPeriod, int duration)
    {
     /* to be implemented in part (b) */ 
     for (int period = startPeriod; period <= endPeriod; period++)
        {
            int freeBlock = findFreeBlock(period, duration);
            if (freeBlock > -1)
            {
                reserveBlock(period,freeBlock,duration);
                return true;
            }
        }
        return false;
    }

    // There may be instance variables, constructors, and methods that are not shown.
    public void printPeriod(int period)
    {
        for (int i = 0; i < schedule[period - 1].length; i++)
        {
            System.out.println(i + " " + schedule[period - 1][i]);
        }

    }

}