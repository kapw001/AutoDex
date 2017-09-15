package autodex.com.autodex.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import autodex.com.autodex.ContactsProvider;
import autodex.com.autodex.R;
import autodex.com.autodex.fragments.ContactsFragment;
import autodex.com.autodex.model.Contact;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by yasar on 13/9/17.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {
    private List<Contact> mContacts;
    private LinkedHashMap<String, Integer> mMapIndex;
    private ArrayList<String> mSectionList;
    private String[] mSections;
    private Context context;

    public ContactsAdapter(Context pContext, List<Contact> mContacts) {
//        mContacts = ContactsProvider.load(pContext);
        this.mContacts = mContacts;
        this.context = pContext;
        fillSections();
    }


    public void updateList(List<Contact> mContacts) {
        this.mContacts.clear();
        this.mContacts.addAll(mContacts);
        fillSections();

        notifyDataSetChanged();
    }


    private void fillSections() {
        mMapIndex = new LinkedHashMap<String, Integer>();

        for (int x = 0; x < mContacts.size(); x++) {
            String fruit = mContacts.get(x).getName();
            if (fruit.length() > 1) {
                String ch = fruit.substring(0, 1);
                ch = ch.toUpperCase();
                if (!mMapIndex.containsKey(ch)) {
                    mMapIndex.put(ch, x);
                }
            }
        }
        Set<String> sectionLetters = mMapIndex.keySet();
        // create a list from the set to sort
        mSectionList = new ArrayList<String>(sectionLetters);
        Collections.sort(mSectionList);

        mSections = new String[mSectionList.size()];
        mSectionList.toArray(mSections);
    }

    @Override
    public ContactsAdapter.ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View content = LayoutInflater.from(context).inflate(R.layout.contact_item, null);
        return new ContactsAdapter.ContactViewHolder(content);
    }

    @Override
    public void onBindViewHolder(ContactsAdapter.ContactViewHolder holder, int position) {
        Contact lContact = getItem(position);
        String section = getSection(lContact);
        holder.bind(lContact, section, mMapIndex.get(section) == position);
    }

    private String getSection(Contact pContact) {
        return pContact.getName().substring(0, 1).toUpperCase();
    }

    private Contact getItem(int pPosition) {
        return mContacts.get(pPosition);
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }


    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private final TextView mName;
        private final TextView mSectionName;
        private final CircleImageView img_contact;

        public ContactViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.name);
            mSectionName = (TextView) itemView.findViewById(R.id.section_title);
            img_contact = (CircleImageView) itemView.findViewById(R.id.img_contact);

        }

        public void bind(Contact pItem, String pSection, boolean bShowSection) {
            mName.setText(pItem.getName());
            mSectionName.setText(pSection);
            mSectionName.setVisibility(bShowSection ? View.VISIBLE : View.GONE);


            if (pItem.getUri() != null) {
                Picasso.with(context).load(pItem.getUri()).fit().into(img_contact);
//                img_contact.setImageURI(pItem.getUri());
                img_contact.setVisibility(View.VISIBLE);
            } else {
                img_contact.setVisibility(View.VISIBLE);
            }

        }
    }
}