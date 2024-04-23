# Arbeiten mit diesem Repository

## Vorbereitungen

- Installiere ein [JDK](https://www.oracle.com/java/technologies/downloads/#jdk21-windows)
- Installiere [Eclipse](https://www.eclipse.org/) oder eine andere IDE
- Installiere [Git](https://git-scm.com/downloads)
- Installiere das Eclipse-Plugin [e(fx)clipse](http://download.eclipse.org/efxclipse/updates-released/)
- Installiere den [Scene Builder](https://gluonhq.com/products/scene-builder/)

## Richte die JavaFX User Library ein

- Lade das [JavaFX SDK](https://gluonhq.com/products/javafx/) herunter
- Entpacke die heruntergeladene Zip-Datei `openjfx-[JavaFX SDK Version]_windows-x64_bin-sdk.zip`
- Kopiere den Unterordner `javafx-sdk-[JavaFX SDK Version]` der entpackten Zip-Datei in den Ordner `C:\Progam Files\Java`
- Starte Eclipse
- Navigiere zu `Window – Preferences – Java – Build Path – User Libraries`
- Betätige die Drucktaste `New...`
- Gib beim Feld `User library name` den Wert `JavaFX [JavaFX SDK Version]` ein und betätige die Drucktaste `OK`
- Wähle den Eintrag `JavaFX [JavaFX SDK Version]` aus und betätige die Drucktaste `Add External JARs...`
- Wähle alle .jar-Dateien des Ordners `C:\Progam Files\Java\javafx-sdk-[JavaFX SDK Version]\lib` aus und betätige die Drucktaste `Open` 
- Führe für jede .jar-Datei nachfolgende Schritte durch:
    - Wähle den Eintrag `JavaFX [JavaFX SDK Version] – <.jar-Datei> – Source attachment: (None)` aus und betätige die Drucktaste `Edit...`
    - Wähle die Option `External location` aus
    - Gib beim Feld `Path` den Wert `C:\Progam Files\Java\javafx-sdk-[JavaFX SDK Version]\lib\src.zip` ein und betätige die Drucktaste `OK`
    - Wähle den Eintrag `JavaFX [JavaFX SDK Version] – <.jar-Datei> – Javadoc location: (None)` aus und betätige die Drucktaste `Edit...`
    - Wähle die Option `Javadoc URL` aus
    - Gib beim Feld `Javadoc location path` den Wert `https://openjfx.io/javadoc/[JavaFX SDK Version]/` ein und betätige die Drucktaste `OK`
- Betätige die Drucktaste `Apply and Close`


## Verknüpfe den Scene Builder mit Eclipse

- Starte Eclipse
- Navigiere zu `Window – Preferences – JavaFX`
- Gib beim Feld `SceneBuilder executable` den Wert `[Pfad zur SceneBuilder.exe]/SceneBuilder.exe` ein und betätige die Drucktaste `Apply and Close`

## Klone das Remote Repository

- Starte die Kommandozeile (z.B. Windows PowerShell)
- Führe den Befehl `git clone https://github.com/appenmaier/java_apps "[Pfad/Der Name Deines lokalen Repositorys]"` aus, um das remote Repository zu klonen

## Binde das lokale Repository in Eclipse ein und bin die JavaFX User Library ein

- Starte Eclipse
- Führe die Funktion `File - Import... - General - Projects from Folder or Archive` aus und betätige die Drucktaste `Next >`
- Gib nachfolgende Informationen ein und betätige die Drucktaste `Finish`
  - Import source: `[Pfad/Der Name Deines lokalen Repositorys]`
- Navigiere im Package Explorer zum Projekt `java_apps` und wähle dieses aus
- Navigiere zu `Project - Properties - Java Build Path` und wähle den Reiter `Libraries` aus
- Wähle die Option `Classpath` aus und betätige die Drucktaste `Add Library...`
- Wähle die Option `User Library` aus und betätige die Drucktaste `Next >`
- Wähle die Option `JavaFX [JavaFX Version]` aus und betätige die Drucktase `Finish`
- Betätige die Drucktaste `Apply and Close`

## Aktualisiere das lokale Repository

- Starte die Kommandozeile (z.B. Windows PowerShell)
- Führe den Befehl `cd "[Pfad/Der Name Deines lokalen Repositorys]"` aus, um zum Arbeitsbereich Deines lokalen Repositorys zu wechseln
- Führe den Befehl `git pull` aus, um den Arbeitsbereich zu aktualisieren

## Führe eine JavaFX-Anwendung aus

### Option 1

- Starte Eclipse
- Navigiere im Package Explorer zur gewünschten JavaFX-Anwendung und wähle die Klasse `App` aus
- Wähle die Option `Run – Run Configurations` aus
- Wähle die Option `Java Application` aus und betätige die Drucktaste `New launch configuration`
- Wähle den Reiter `Arguments` aus
- Gib beim Feld `VM arguments` den Wert `--module-path "C:\Program Files\Java\javafx-sdk-[JavaFX SDK Version]\lib" --add-modules=javafx.controls,javafx.fxml` ein und betätige die Drucktaste `Run`

### Option 2

- Navigiere im Package Explorer zur gewünschten JavaFX-Anwendung und wähle die Klasse `MainClass` aus
- Wähle die Option `Run As - 1 Java Application` aus
