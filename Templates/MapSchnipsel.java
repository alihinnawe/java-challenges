import java.util.*;

Map <String, String> arde = new HashMap <> ();

arde.put ("\\$NAME", "DonnerstagDemo");
arde.put ("\\$name", "donnerstagDemo");
arde.put ("\\$DATE", "" + new Date ());

String [] text = {
	"class $NAME extends JFrame", 
	"Erzeugt $DATE", 
	"$NAME $name = new $NAME ();",
	"SwingUtilities.invokeLater ($name ())"
	};

for (String s : text)
{   
	for (String key: arde.keySet())
       s = s.replaceAll (key, arde.get (key)); 
    println (s);
}

