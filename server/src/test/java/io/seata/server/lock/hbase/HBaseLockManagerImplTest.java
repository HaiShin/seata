/*
 *  Copyright 1999-2019 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.seata.server.lock.hbase;

import io.seata.core.exception.TransactionException;
import io.seata.core.lock.Locker;
import io.seata.server.lock.LockManager;
import io.seata.server.session.BranchSession;
import io.seata.server.storage.hbase.lock.HBaseLockManager;
import io.seata.server.storage.hbase.lock.HBaseLocker;
import io.seata.server.storage.hbase.lock.LockStoreHBaseDao;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * ClassName: HBaseLockManagerImplTest
 * Description:
 *
 * @author haishin
 */
@SpringBootTest
public class HBaseLockManagerImplTest {

    static LockManager lockManager = null;
    static Connection connection = null;

   /* @BeforeAll
    public static void start(ApplicationContext context) throws Exception {

        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", "hadoop1");
        configuration.set("hbase.client.retries.number", "3");

        try {
            connection = ConnectionFactory.createConnection(configuration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        lockManager = new HBaseLockManagerForTest();
    }

    @Test
    public void acquireLock() throws TransactionException {
        BranchSession branchSession = new BranchSession();
        branchSession.setXid("abc-123:786756");
        branchSession.setTransactionId(123543465);
        branchSession.setBranchId(5756678);
        branchSession.setResourceId("abcss");
        branchSession.setLockKey("t1:13,14;t2:11,12");
        Assertions.assertTrue(lockManager.acquireLock(branchSession));
    }

    @Test
    public void re_acquireLock() throws TransactionException {
        BranchSession branchSession = new BranchSession();
        branchSession.setXid("abc-123:65867978");
        branchSession.setTransactionId(123543465);
        branchSession.setBranchId(5756678);
        branchSession.setResourceId("abcss");
        branchSession.setLockKey("t1:53,54;t2:21,32");

        Assertions.assertTrue(lockManager.acquireLock(branchSession));

        BranchSession branchSession2 = new BranchSession();
        branchSession2.setXid("abc-123:65867978");
        branchSession2.setTransactionId(123543465);
        branchSession2.setBranchId(575667854);
        branchSession2.setResourceId("abcss");
        branchSession2.setLockKey("t1:13,14;t2:21,45");

        Assertions.assertTrue(lockManager.acquireLock(branchSession2));

        BranchSession branchSession3 = new BranchSession();
        branchSession3.setXid("abc-123:5678789");
        branchSession3.setTransactionId(334123);
        branchSession3.setBranchId(5657);
        branchSession3.setResourceId("abcss");
        branchSession3.setLockKey("t1:53,14;t2:21,45");

        Assertions.assertTrue(!lockManager.acquireLock(branchSession3));

    }

    @Test
    public void unLock() throws TransactionException {
        BranchSession branchSession = new BranchSession();
        branchSession.setXid("abc-123:56867");
        branchSession.setTransactionId(1236765);
        branchSession.setBranchId(204565);
        branchSession.setResourceId("abcss");
        branchSession.setLockKey("t1:3,4;t2:4,5");
        Assertions.assertTrue(lockManager.releaseLock(branchSession));
    }

    @Test
    public void isLockable() throws TransactionException {
        BranchSession branchSession = new BranchSession();
        branchSession.setXid("abc-123:56877898");
        branchSession.setTransactionId(56877898);
        branchSession.setBranchId(467568);
        branchSession.setResourceId("abcss");
        branchSession.setLockKey("t1:8,7;t2:1,2");

        Assertions.assertTrue(lockManager.acquireLock(branchSession));

        BranchSession branchSession2 = new BranchSession();
        branchSession2.setXid("abc-123:56877898");
        branchSession2.setTransactionId(56877898);
        branchSession2.setBranchId(1242354576);
        branchSession2.setResourceId("abcss");
        branchSession2.setLockKey("t1:8");

        Assertions.assertTrue(lockManager.isLockable(branchSession2.getXid(), branchSession2.getResourceId(), branchSession2.getLockKey()));

        BranchSession branchSession3 = new BranchSession();
        branchSession3.setXid("abc-123:4575614354");
        branchSession3.setTransactionId(65867867);
        branchSession3.setBranchId(123123);
        branchSession3.setResourceId("abcss");
        branchSession3.setLockKey("t2:1,12");

        Assertions.assertTrue(!lockManager.isLockable(branchSession3.getXid(), branchSession3.getResourceId(), branchSession3.getLockKey()));
    }


    public static class HBaseLockManagerForTest extends HBaseLockManager {

        public HBaseLockManagerForTest() {
        }

        @Override
        public Locker getLocker(BranchSession branchSession) {
            HBaseLocker locker = new HBaseLocker(connection, "seata:lockTable", "seata:lockKey", "lock", "transactionId");
            return locker;
        }
    }*/

}
