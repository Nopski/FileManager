import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class MyFileManager {
    private String enter;
    public void Manger() {
        System.out.println("Enter path: ");
        Scanner input = new Scanner(System.in);
        enter = input.nextLine();
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            Path dir = Paths.get(enter);
            dir.register(watcher, ENTRY_MODIFY, ENTRY_CREATE, ENTRY_DELETE);
            System.out.println("File path is finding " + dir.getFileName());

            while (true) {
                WatchKey key;
                try {
                    key = watcher.take();
                } catch (InterruptedException ex) {
                    return;
                }
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    System.out.println("Path: " + kind.name());

                    if (kind == ENTRY_MODIFY) {
                        System.out.println("Home dir changed!");
                    }
                }
                key.reset();
            }
        }catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
