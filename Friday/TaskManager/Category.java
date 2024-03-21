/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Friday.TaskManager;

/**
 *
 * @author PC 4060TI
 */
public enum Category {
    REQUIREMENT (0), DEVELOPMENT (1), TEST (2);
    
    private int prioridad;

    private Category(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
}
