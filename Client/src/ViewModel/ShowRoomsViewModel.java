package ViewModel;

import Model.ModelClient;
import Model.Room;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ShowRoomsViewModel extends ViewModel implements PropertyChangeListener {
    private ViewState viewState;
    private ModelClient model;
    private ObservableList<String> list;
    private StringProperty selectedObject;

    public ShowRoomsViewModel(ModelClient model, ViewState viewState) {
        this.model = model;
        this.viewState = viewState;
        this.list = FXCollections.observableArrayList();
        this.selectedObject = new SimpleStringProperty();
        this.model.addListener(this);
        clear();

    }

    @Override
    public void clear() {
        list.clear();
        for (Room room : model.getAllRooms()) {
            if (!room.isReserved()) {
                list.add(room.getAnnouncement());
            }
        }
    }

    public ObservableList<String> getList() {
        return list;
    }

    public void setSelectedObject(String id) {
        this.selectedObject.set(id);
    }

    public void setId(String id) {
        viewState.setId(id);
    }

    public void roomDetails() {
        Room room = model.getRoomByAnnouncement(selectedObject.get());

        viewState.setId(room.getRoomId());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("RemoveRoom"))
            Platform.runLater(() -> {
                clear();
            });
        if (evt.getPropertyName().equals("roomReserved"))
            Platform.runLater(() -> {
                clear();
            });


    }
}
