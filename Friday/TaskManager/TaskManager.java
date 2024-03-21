/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Friday.TaskManager;

import org.model.LinkedList.doubly.circular.LinkedList;
import org.model.array.Array;
import org.model.priorityQueue.list.PriorityQueue;
import org.model.util.iterator.Iterator;

/**
 *
 * @author informatica
 */
public class TaskManager {

    Array<PriorityQueue<Task>> taskManager;

    public TaskManager() {
        taskManager = new Array<>(25);
        while (taskManager.size() != 25) {
            taskManager.add(new PriorityQueue<>(3));
        }
    }

    public void addTask(Task task) {
        if (task.getPriority() == 0 || task.getPriority() > 25) {
            taskManager.get(24).insert(task.getCategory().getPrioridad(), task);
        } else {
            taskManager.get(task.priority - 1).insert(task.getCategory().getPrioridad(), task);
        }
    }

    public Task searchByName(String name) {
        Iterator<Task> iterator;
        for (int i = taskManager.size() - 1; i >= 0; i--) {
            iterator = taskManager.get(i).iterator();
            while (iterator.hasNext()) {
                Task task = iterator.next();
                if (task.getTaskName().equals(name)) {
                    return task;
                }
            }
        }
        return Task.returnNullTask();
    }

    public Task searchByDescription(String description) {
        Iterator<Task> iterator;
        for (int i = taskManager.size() - 1; i >= 0; i--) {
            iterator = taskManager.get(i).iterator();
            while (iterator.hasNext()) {
                Task task = iterator.next();
                if (task.getDescription().equals(description)) {
                    return task;
                }
            }
        }
        return Task.returnNullTask();
    }

    public LinkedList<Task> returnCircularList(String description) {
        LinkedList<Task> circularTasks = new LinkedList<>();
        Iterator<Task> iterator;
        for (int i = taskManager.size() - 1; i >= 0; i--) {
            iterator = taskManager.get(i).iterator();
            while (iterator.hasNext()) {
                Task task = iterator.next();
                circularTasks.add(task);
            }
        }
        circularTasks.reverse();
        return circularTasks;
    }
    
    public void reorganizeByCategory(String taskName, Category category){
        
    }
    
    private void extractAnTask(int priority, String taskName){
        PriorityQueue<Task> pQ = taskManager.get(priority-1);
        while (!pQ.isEmpty()){
            Task task = pQ.extract();
            if (!task.getTaskName().equals(taskName)){
                pQ.insert(task.getCategory().getPrioridad(), task);
            }
        }
    }

}
