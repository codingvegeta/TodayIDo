const Sequelize = require('sequelize');

class Comment extends Sequelize.Model {
    static initiate(sequelize){
        Comment.init({
            comment: {
                type: Sequelize.STRING(100),
                allowNull: false,
            },
            create_at: {
                type: Sequelize.DATE,
                allowNull: false,
                defaultValue: Sequelize.NOW,
            },
        }, {
            sequelize,
            timestamp: false,
            modelName: 'Comment',
            tableName: 'comment',
            paranoid: false,
            charset: 'utf8mb4',
            collate: 'utf8mb4_general_ci',

        });
    }

    static associate(db) {
        db.Comment.belongsTo(db.User, {foreignKey: 'commenter', targetKey: 'id'});
    }
};

module.exports= Comment;