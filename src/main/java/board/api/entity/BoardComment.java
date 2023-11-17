package board.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="board_comment")
public class BoardComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String author_name;

    @Column
    private String content;

    @Column
    private Timestamp date;

    @ManyToOne
    private Board board;

    @Column(name = "boardtoid")
    private Long boardId;

    public BoardComment (Long id) {
        this.boardId = id;
    }
}