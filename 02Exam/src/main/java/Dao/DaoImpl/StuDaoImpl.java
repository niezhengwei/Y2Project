package Dao.DaoImpl;

import Dao.DaoBase;
import Dao.StuDao;
import entity.userinfo;

/**
 * Created by leon on 2018/2/1.
 */
public class StuDaoImpl extends DaoBase implements StuDao{
    public int insert(userinfo info) {
        String sql="INSERT INTO student(stuname,topicid,topicanswer,createtime,classname)VALUES(?,?,?,?,?)";
        int i = exeUpDate(sql, info.getStuname(), info.getTopicid(), info.getTopicanswer(), info.getCreatetime(),info.getClassname());
      if(i>0){
          return i;
      }
        return 0;
    }
}
