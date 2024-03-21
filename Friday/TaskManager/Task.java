/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Friday.TaskManager;

/**
 *
 * @author PC 4060TI
 */
public class Task {
    String taskName;
    int priority;
    Category category;
    boolean completionStatus;
    String description;

    public Task(String taskName, int priority, Category category, boolean completionStatus, String description) {
        this.taskName = taskName;
        this.priority = priority;
        this.category = category;
        this.completionStatus = completionStatus;
        this.description = description;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public static Task returnNullTask(){
        return new Task("", -1,Category.TEST, false, "");
    }
    
    
}
