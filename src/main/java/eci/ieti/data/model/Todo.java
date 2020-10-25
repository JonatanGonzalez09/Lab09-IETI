package eci.ieti.data.model;

public class Todo {
    private String description;
    private int priority;
    private String dueDate;
    private String responsible;
    private String status;

    public Todo(){

    }

    public Todo(String description, int priority, String dueDate, String responsible, String status){
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.responsible = responsible;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getResponsible() {
        return responsible;
    }

    public String getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
	public String toString() {
		return "Todo [description=" + description + ", priority=" + priority + ", dueDate=" + dueDate + ", responsible=" + responsible +", status="+ status +"]";
	}
}
