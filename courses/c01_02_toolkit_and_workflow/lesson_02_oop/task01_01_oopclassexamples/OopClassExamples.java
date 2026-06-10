package c01_02_toolkit_and_workflow.lesson_02_oop.task01_01_oopclassexamples;
/**
 * В данном файле приведены примеры классов для трех программ:
 * - Telegram;
 * - YouTube;
 * - Moon+ Reader - приложение для чтения электронных книг.
 */

// Telegram
class User { // пользователь
    int id; // уникальный идентификатор
    int phoneNumber; // номер телефона
    String username; // @никнейм
    String firstName; // имя
    String lastName; // фамилия
    boolean isOnline; // статус пользователя
}
class Message { // сообщение
    int id; // идентификатор сообщения
    int senderId; // идентификатор отправителя
    String text; // текст сообщения
    boolean isRead; // статус прочтения
}
class Channel {
    int id; // идентификатор канала
    String title; // название канала
    String description; // описание
    String username; // короткий адрес (@example)
    int ownerId; // идентификатор владельца
    int subscriberCount; // количество подписчиков
    boolean isPrivate; // приватный или публичный канал
}

// YouTube
class Video {
    int id; // идентификатор видео
    String title; // название
    String description; // описание
    String channelId; // идентификатор канала
    boolean isPublic; // публичное или приватное видео
    int viewCount; // количество просмотров
    int likeCount; // количество лайков
}
class ChannelYouTube {
    int id; // идентификатор канала
    String name; // отображаемое имя
    int ownerId; // идентификатор владельца
    int creationDate; // дата создания
    String description; // описание канала
    int subscriberCount; // количество подписчиков
    int videoCount; // количество видео
}
class Comment { // комментарий
    int id; // идентификатор комментария
    int videoId; // идентификатор видео
    int authorId; // идентификатор автора комментария
    String text; // текст комментария
    int timestamp; // время публикации
    boolean isPinned; // закреплен ли комментарий
    int likeCount; // количество лайков
}

// Moon+ Reader - приложение для чтения электронных книг на телефоне.
class Book { // книга
    int id; // идентификатор книги
    String title; // название
    String author; // автор
    int totalPages; // количество страниц
    int currentPage; // текущая страница
    int lastReadTimestamp; // дата последнего открытия
}
class Bookmark { // закладка
    int id; // идентификатор закладки
    int bookId; // идентификатор книги
    int pageNumber; // номер страницы
    String description; // заметка пользователя
    int createdAt; // дата создания
    String color; // цвет закладки
}
class Highlight { // выделение текста
    int id; // идентификатор выделения
    int bookId; // идентификатор книги
    int pageNumber; // номер страницы
    int startOffset; // начальная позиция текста
    int endOffset; // конечная позиция текста
    String selectedText; // выделенный текст
    String note; // заметка пользователя
    String color; // цвет выделения
    int createdAt; // дата создания
}

public class OopClassExamples {

}
