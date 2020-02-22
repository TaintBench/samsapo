package android.support.v4.net;

import android.os.Build.VERSION;
import java.net.Socket;
import java.net.SocketException;

public class TrafficStatsCompat {
    private static final TrafficStatsCompatImpl IMPL;

    static class BaseTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        private ThreadLocal<SocketTags> mThreadSocketTags;

        private static class SocketTags {
            public int statsTag;

            private SocketTags() {
                this.statsTag = -1;
            }

            /* synthetic */ SocketTags(AnonymousClass1 anonymousClass1) {
                AnonymousClass1 anonymousClass12 = anonymousClass1;
                this();
            }
        }

        BaseTrafficStatsCompatImpl() {
            ThreadLocal threadLocal = r5;
            ThreadLocal anonymousClass1 = new ThreadLocal<SocketTags>(this) {
                final /* synthetic */ BaseTrafficStatsCompatImpl this$0;

                {
                    this.this$0 = r5;
                }

                /* access modifiers changed from: protected */
                public SocketTags initialValue() {
                    SocketTags socketTags = r4;
                    SocketTags socketTags2 = new SocketTags();
                    return socketTags;
                }
            };
            this.mThreadSocketTags = threadLocal;
        }

        public void clearThreadStatsTag() {
            ((SocketTags) this.mThreadSocketTags.get()).statsTag = -1;
        }

        public int getThreadStatsTag() {
            return ((SocketTags) this.mThreadSocketTags.get()).statsTag;
        }

        public void incrementOperationCount(int i) {
        }

        public void incrementOperationCount(int i, int i2) {
        }

        public void setThreadStatsTag(int i) {
            ((SocketTags) this.mThreadSocketTags.get()).statsTag = i;
        }

        public void tagSocket(Socket socket) {
        }

        public void untagSocket(Socket socket) {
        }
    }

    static class IcsTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        IcsTrafficStatsCompatImpl() {
        }

        public void clearThreadStatsTag() {
            TrafficStatsCompatIcs.clearThreadStatsTag();
        }

        public int getThreadStatsTag() {
            return TrafficStatsCompatIcs.getThreadStatsTag();
        }

        public void incrementOperationCount(int i) {
            TrafficStatsCompatIcs.incrementOperationCount(i);
        }

        public void incrementOperationCount(int i, int i2) {
            TrafficStatsCompatIcs.incrementOperationCount(i, i2);
        }

        public void setThreadStatsTag(int i) {
            TrafficStatsCompatIcs.setThreadStatsTag(i);
        }

        public void tagSocket(Socket socket) throws SocketException {
            TrafficStatsCompatIcs.tagSocket(socket);
        }

        public void untagSocket(Socket socket) throws SocketException {
            TrafficStatsCompatIcs.untagSocket(socket);
        }
    }

    interface TrafficStatsCompatImpl {
        void clearThreadStatsTag();

        int getThreadStatsTag();

        void incrementOperationCount(int i);

        void incrementOperationCount(int i, int i2);

        void setThreadStatsTag(int i);

        void tagSocket(Socket socket) throws SocketException;

        void untagSocket(Socket socket) throws SocketException;
    }

    public TrafficStatsCompat() {
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            IcsTrafficStatsCompatImpl icsTrafficStatsCompatImpl = r2;
            IcsTrafficStatsCompatImpl icsTrafficStatsCompatImpl2 = new IcsTrafficStatsCompatImpl();
            IMPL = icsTrafficStatsCompatImpl;
            return;
        }
        BaseTrafficStatsCompatImpl baseTrafficStatsCompatImpl = r2;
        BaseTrafficStatsCompatImpl baseTrafficStatsCompatImpl2 = new BaseTrafficStatsCompatImpl();
        IMPL = baseTrafficStatsCompatImpl;
    }

    public static void clearThreadStatsTag() {
        IMPL.clearThreadStatsTag();
    }

    public static int getThreadStatsTag() {
        return IMPL.getThreadStatsTag();
    }

    public static void incrementOperationCount(int i) {
        IMPL.incrementOperationCount(i);
    }

    public static void incrementOperationCount(int i, int i2) {
        IMPL.incrementOperationCount(i, i2);
    }

    public static void setThreadStatsTag(int i) {
        IMPL.setThreadStatsTag(i);
    }

    public static void tagSocket(Socket socket) throws SocketException {
        IMPL.tagSocket(socket);
    }

    public static void untagSocket(Socket socket) throws SocketException {
        IMPL.untagSocket(socket);
    }
}
