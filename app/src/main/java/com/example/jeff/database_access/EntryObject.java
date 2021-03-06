package com.example.jeff.database_access;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class EntryObject {

    public static final DateFormat DAY_DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    public static final DateFormat TIME_FORMAT = new SimpleDateFormat("hh:mm a");

    private long id;
    private long group_id;
    private String title;
    private Date start;
    private Date end;
    private int file_count;
    private int priority;
    private String recurrence;
    private String description;

    private UserObject user = null;
    private GroupObject group = null;


    public EntryObject(){
        id = -1;
        group_id = -1;
        title = null;
        start = null;
        end = null;
        file_count = 0;
        priority = -1;
        recurrence = null;
        description = null;
    }

    public EntryObject(UserObject user){
        this();
        setUser(user);
    }

    public EntryObject(JSONObject jo){
        parseIdFromJson(jo);
        parseGidFromJson(jo);
        parseTitleFromJson(jo);
        parseStartFromJson(jo);
        parseEndFromJSON(jo);
        parseFileCountFromJson(jo);
        parsePriorityFromJson(jo);
        parseRecurrenceFromJson(jo);
        parseDescriptionFromJson(jo);
    }

    public UserObject getUser() {
        return user;
    }

    public void setUser(UserObject user) {
        this.user = user;
    }



    public long getId() { return id; }
    public long getGroupId(){ return group_id; }

    public String getTitle() { return title; }

    public Date getStart() { return start; }

    public Date getEnd() { return end; }

    public int getFileCount() { return file_count; }

    public int getPriority() { return priority; }

    public String getRecurrence() { return recurrence; }

    public String getDescription() { return description; }

    public boolean isTask(){
        return getStart() == null && getEnd() != null;
    }

    public boolean isEvent(){
        return getStart() != null && getEnd() != null;
    }

    public boolean isNotice(){
        return getStart() != null && getEnd() == null;
    }


    public void setTitle(String title) { this.title = title; }

    public void setStart(Date start) { this.start = start; }

    public void setEnd(Date end) { this.end = end; }

    public void setRecurrence(String recurrence) { this.recurrence = recurrence; }

    public void setPriority(int priority) { this.priority = priority; }

    public void setDescription(String description) { this.description = description; }








    public String toString(){
        return new StringBuilder().append("EntryObject")
                .append(", ").append(getId())
                .append(", ").append(getTitle())
                .append(", ").append(getStart())
                .append(", ").append(getEnd())
                .append(", ").append(getFileCount())
                .append(", ").append(getPriority())
                .append(", ").append(getRecurrence())
                .append(", ").append(getDescription())
                .toString();
    }






    public void applyGroupAsOwner(GroupObject group, long entry_id){
        group_id = group.getId();
        this.id = entry_id;
        group.addEntryCheckGID(this);
        setUser(group.getUser());
        setGroup(group);
    }


    public static Date getDayDateFromString(String day_string){
        if(day_string == null) return null;
        Date toret = null;
        try {
            toret = DAY_DATE_FORMAT.parse(day_string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return toret;
    }


    public static String getDayString(Date date){
        if(date == null) return null;
        return DAY_DATE_FORMAT.format(date);
    }

    public String getDayString(){
        return getDayString(getStart() == null ? getEnd() : getStart() );
    }

    public static String getDayOfWeek(Date date) {
        return new SimpleDateFormat("EEE").format(date);
    }

    public static String getTimeString(Date date) { return TIME_FORMAT.format(date);}



    // Deletes this entry from the database and attempts to remove all references to this
    // from the Java program
    public boolean delete(){

        try {
            if(DatabaseRequest.delete_entry(this)){
                getUser().removeEntryFromLists(this);
                this.id = -1;
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }

    public String getGroupName() throws IOException {
        return DatabaseRequest.get_group_name(this.group_id);
    }



    public boolean pushUpdate(){
        EntryObject eo = null;
        try {
            eo = DatabaseRequest.update_entry(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return eo == this;
    }








    /*Below are private parsing methods for handling extraction of information from JSONObjects
     Used by the constructor. */

    private void parseIdFromJson(JSONObject jo){
        id = JsonHelper.parseLong(jo, "id");
    }
    private void parseGidFromJson(JSONObject jo){
        group_id = JsonHelper.parseLong(jo, "gid");
    }
    private void parseTitleFromJson(JSONObject jo){
        title = JsonHelper.parseString(jo, "title");
    }
    private void parseStartFromJson(JSONObject jo){
        start = JsonHelper.parseDate(jo, "start");
    }
    private void parseEndFromJSON(JSONObject jo){
        end = JsonHelper.parseDate(jo, "end");
    }
    private void parseFileCountFromJson(JSONObject jo){
        file_count = JsonHelper.parseInt(jo, "file_count");
    }
    private void parsePriorityFromJson(JSONObject jo){
        priority = JsonHelper.parseInt(jo, "priority");
    }
    private void parseRecurrenceFromJson(JSONObject jo){
        recurrence = JsonHelper.parseString(jo, "recurrence");
    }
    private void parseDescriptionFromJson(JSONObject jo){
        description = JsonHelper.parseString(jo, "description");
    }

    public void setGroup(GroupObject group) {
        this.group = group;
    }
}
/*..........`                          ` -..........................::::::::::::
............`                         `..:-::::-...................`:///////////
............`                  ``.-:://+++++sosss+:................`:///////////
...........``              `.-+yyyyhhhhyyhdhhhddhhyo:.-:::--.......`-///////////
...........``           `.:oshdhhhddmmNmmmmmdmmdmmddsoo+++++/:..``.`:///////////
............`         ./oyyydddmddmmmmmmmmmmmmmmmmmmmmddddhhyso:..``:///++++++++
............`     ``-+shmmmmddhhyyyyysssossyhddmmddmNNNmmmmmdhs+:..`-/+sssssssss
...........``    `-/oymNNNmho+///////:::::/:/++oo+oshdNNNNNNNmho:--.-/+sssssssss
............`   `/oyhmNNNy/:-------------.------:-::/+sdmNMNNNdy+:---:+ossssssso
...........``  `:oydmNNd+:-----..-..........--------::/oymNMMNNds/--.--/++++oooo
...........`` `-/ydmNNh:---......................-----:/+shNNNNdho/.
```........``` :ohdNNy:--........................-----://+odNNNmdy+:``.---------
`````......`` `+ohmNy:-...........................----:::/ohNNmmhys/.://+ooooooo
``````````````.shdNy:-.............................----:::+ymNNddyhy/:/++oosssoo
`````````...``-yhmm+-.....................`........-----::+ymmNdyddho/+oosssssss
``````````````:shmh:.........``.........````.......-----::/ydmmddhdhyo/+oossssss
``````````    /yhhs-....---...........`...........------:/+yhmmmmmdddh+///++++++
             `-yys+-./osssssss+/-......:osso+++oo+:----::/+yhdmNNmmdhy::////////
             `.oo+/.:osoo++oo+++/.....-/o+ossssssyys+::://+yyhmmNNmmds//////////
              `+//-.-::::/++o+::/:...-:::///:--::://+/:::+oyyyhdmmmdh+//////////
               -/...--/os+so+:+//:---:+//o++hyyss+:---:::/+syhhhhyhy:/++++//////
               `:-.---:--::---::::-::/+/:::---::+o/:---::/+ohys++///-ooooooooooo
                .-.--..-----.--::--:///::--------------:::+o+:--:-/--ooooooooooo
                `..-----------::--:///:::----------.--:::://--..-.:.`//+++++++++
                 .-.-------.-::---:////:-..------------:::/..`.`-``
                 ..-----..-.:/:---:/++//--...---::-----:::/.----`
                 .-----.---:oshsoo+/o+++:---------::--::::/-.--.
                 -------+syhmdhhysyyhhhyo/////:-.--::-::/::..-:`
                 -----/hmdhddddhyyyhyhhddhhhhhy/----::://:::+s-
                 ----./o+oyhs+++++/+soshsssss+o/-.--/////:yhds`
                 .---..:::/os+:-....-:+oso/::-:-.--:///+//+os.
                  ---..-:-::///////://///:-----.---:/+////```
                  `---------::::::::::/:----------:/++/+/:
                   .::----------:-:----------:--::/+++++::
                    `::-----::::----::----:::/:-:/+++++/::.
                     `:::---:::-----------:///:/++++++//://`````
                      .:///::::::::-:-:--/+oo++++//++//////:``````
                      `-:://+++o++ooooooooo+/////:///::://:+:`` ``
                      `--:::////++/+++oo+/////:::://::::://:``   ``
                      `----::///////++//::::::-:-:::::::::`   `````           */