package zum1;

import java.util.Comparator;

public class NodeComparator implements Comparator<Map.Node> {
    @Override
    public int compare(Map.Node node, Map.Node goal) {
            if (node.manDist < goal.manDist)
                return -1;
            else if(node.manDist > goal.manDist)
                return 1;
            return 0;
        }
}
