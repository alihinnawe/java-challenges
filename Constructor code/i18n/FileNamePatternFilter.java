import javax.swing.filechooser.*;
import java.io.File;

class FileNamePatternFilter extends FileFilter 
{
	private String description, pattern;

	public FileNamePatternFilter (String desc, String pattern)
	{
		description = desc;
		this.pattern = pattern;
	}

	public boolean accept (File f)
	{
		return f.getName().matches (pattern);
	}
	
	public String getDescription ()
	{
		return description; 
	}
}
