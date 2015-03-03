package com.nickbrown;

/**
 * Created by nick on 03/03/15.
 */
public class ScreenReference {

    private final String FXML_FILE_EXTENSION = ".fxml";
    private String controllerName;
    private String fxmlFileName;

    public ScreenReference(final String screenName) {
        setControllerName(screenName);
        setFxmlFileNameFromControllerName(screenName);
    }

    public ScreenReference(final String controllerName, final String fxmlFileName) {
        setControllerName(controllerName);
        setFxmlFileName(fxmlFileName);
    }

    private void setControllerName(final String controllerName) {
        this.controllerName = controllerName;
    }

    public String getControllerName() {
        return this.controllerName;
    }

    private void setFxmlFileNameFromControllerName(String controllerName) {
        setFxmlFileName(controllerName + FXML_FILE_EXTENSION);
    }

    private void setFxmlFileName(final String fxmlFileName) {
        this.fxmlFileName = fxmlFileName;
    }

    public String getFxmlFileName() {
        return this.fxmlFileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScreenReference that = (ScreenReference) o;

        if (!controllerName.equals(that.controllerName)) return false;
        if (!fxmlFileName.equals(that.fxmlFileName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = controllerName.hashCode();
        result = 31 * result + fxmlFileName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "[" + controllerName + ":" + fxmlFileName + "]";
    }
}
