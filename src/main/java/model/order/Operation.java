package model.order;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * <b>Данные об операции</b>
 */
@XmlType(name = "Operation")
public class Operation {

    /**
     * ID операции
     */
    @XmlAttribute(name = "id")
    private long id;

    /**
     * Название операции (не знаю, нужно ли оно нам, может пригодиться)
     */
    @XmlAttribute(name = "name")
    private String name;

    /**
     * Длительность в секундах
     */
    @XmlAttribute(name = "duration")
    private int duration;

    /**
     * Необходимое для выполнения операции оборудование
     */
    @XmlAttribute(name = "equipment_group")
    private long requiredEquipment;

    /**
     * ID предыдущей операции
     */
    @XmlAttribute(name = "prev_operation_id")
    private long prevOperationId;

    /**
     * ID следующей операции
     */
    @XmlAttribute(name = "next_operation_id")
    private long nextOperationId;

    public Operation() {

    }

    public Operation(long id, String name, int duration, long requiredEquipment, long prevOperationId, long nextOperationId) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.requiredEquipment = requiredEquipment;
        this.prevOperationId = prevOperationId;
        this.nextOperationId = nextOperationId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public Long getRequiredEquipment() {
        return requiredEquipment;
    }

    public long getPrevOperationId() {
        return prevOperationId;
    }

    public long getNextOperationId() {
        return nextOperationId;
    }
}
